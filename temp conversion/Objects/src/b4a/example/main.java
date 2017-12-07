package b4a.example;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = main.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcel = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblkel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtkel = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblfah = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtfah = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblrea = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtrea = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
public static float _cel = 0f;
public static float _kel = 0f;
public static float _fah = 0f;
public static float _rea = 0f;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="lblcel.Initialize(\"lblcel\")";
mostCurrent._lblcel.Initialize(mostCurrent.activityBA,"lblcel");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="lblcel.Text = \"Celcius\"";
mostCurrent._lblcel.setText((Object)("Celcius"));
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.AddView(lblcel,10%x, 10%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lblcel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="txtcel.Initialize(\"txtCel\")";
mostCurrent._txtcel.Initialize(mostCurrent.activityBA,"txtCel");
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="txtcel.InputType = txtcel.INPUT_TYPE_DECIMAL_NUMBERS";
mostCurrent._txtcel.setInputType(mostCurrent._txtcel.INPUT_TYPE_DECIMAL_NUMBERS);
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="Activity.AddView(txtcel,55%x, 5%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._txtcel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (55),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="lblkel.Initialize(\"lblkel\")";
mostCurrent._lblkel.Initialize(mostCurrent.activityBA,"lblkel");
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="lblkel.Text = \"Kelvin\"";
mostCurrent._lblkel.setText((Object)("Kelvin"));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="Activity.AddView(lblkel,10%x, 20%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lblkel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="txtkel.Initialize(\"txtkel\")";
mostCurrent._txtkel.Initialize(mostCurrent.activityBA,"txtkel");
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="txtkel.InputType = txtkel.INPUT_TYPE_NONE";
mostCurrent._txtkel.setInputType(mostCurrent._txtkel.INPUT_TYPE_NONE);
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Activity.AddView(txtkel,55%x, 15%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._txtkel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (55),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="lblfah.Initialize(\"lblfah\")";
mostCurrent._lblfah.Initialize(mostCurrent.activityBA,"lblfah");
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="lblfah.Text = \"Fahrenheit\"";
mostCurrent._lblfah.setText((Object)("Fahrenheit"));
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="Activity.AddView(lblfah,10%x, 30%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lblfah.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="txtfah.Initialize(\"txtfah\")";
mostCurrent._txtfah.Initialize(mostCurrent.activityBA,"txtfah");
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="txtfah.InputType = txtfah.INPUT_TYPE_NONE";
mostCurrent._txtfah.setInputType(mostCurrent._txtfah.INPUT_TYPE_NONE);
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="Activity.AddView(txtfah,55%x, 25%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._txtfah.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (55),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="lblrea.Initialize(\"lblrea\")";
mostCurrent._lblrea.Initialize(mostCurrent.activityBA,"lblrea");
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="lblrea.Text = \"Reamur\"";
mostCurrent._lblrea.setText((Object)("Reamur"));
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="Activity.AddView(lblrea,10%x, 40%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._lblrea.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="txtrea.Initialize(\"txtrea\")";
mostCurrent._txtrea.Initialize(mostCurrent.activityBA,"txtrea");
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="txtrea.InputType = txtrea.INPUT_TYPE_NONE";
mostCurrent._txtrea.setInputType(mostCurrent._txtrea.INPUT_TYPE_NONE);
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="Activity.AddView(txtrea,55%x, 35%y, 20%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._txtrea.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (55),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (35),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="btnOK.Initialize(\"btnOK\")";
mostCurrent._btnok.Initialize(mostCurrent.activityBA,"btnOK");
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="btnOK.Text = \"KONVERSI\"";
mostCurrent._btnok.setText((Object)("KONVERSI"));
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="Activity.AddView(btnOK,10%x, 80%y, 80%x, 10%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._btnok.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _btnok_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub btnOK_click";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="cel = txtcel.Text";
_cel = (float)(Double.parseDouble(mostCurrent._txtcel.getText()));
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="kel = cel + 273";
_kel = (float) (_cel+273);
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="fah = (9/5)*cel + 32";
_fah = (float) ((9/(double)5)*_cel+32);
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="rea = (4/5)*cel";
_rea = (float) ((4/(double)5)*_cel);
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="txtkel.Text = kel";
mostCurrent._txtkel.setText((Object)(_kel));
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="txtfah.Text = fah";
mostCurrent._txtfah.setText((Object)(_fah));
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="txtrea.Text = rea";
mostCurrent._txtrea.setText((Object)(_rea));
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="End Sub";
return "";
}
}