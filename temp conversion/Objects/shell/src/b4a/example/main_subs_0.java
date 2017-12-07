package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 49;BA.debugLine="lblcel.Initialize(\"lblcel\")";
Debug.ShouldStop(65536);
main.mostCurrent._lblcel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("lblcel")));
 BA.debugLineNum = 50;BA.debugLine="lblcel.Text = \"Celcius\"";
Debug.ShouldStop(131072);
main.mostCurrent._lblcel.runMethod(true,"setText",RemoteObject.createImmutable(("Celcius")));
 BA.debugLineNum = 51;BA.debugLine="Activity.AddView(lblcel,10%x, 10%y, 20%x, 10%y)";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._lblcel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 53;BA.debugLine="txtcel.Initialize(\"txtCel\")";
Debug.ShouldStop(1048576);
main.mostCurrent._txtcel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("txtCel")));
 BA.debugLineNum = 54;BA.debugLine="txtcel.InputType = txtcel.INPUT_TYPE_DECIMAL_NUMBERS";
Debug.ShouldStop(2097152);
main.mostCurrent._txtcel.runMethod(true,"setInputType",main.mostCurrent._txtcel.getField(true,"INPUT_TYPE_DECIMAL_NUMBERS"));
 BA.debugLineNum = 55;BA.debugLine="Activity.AddView(txtcel,55%x, 5%y, 20%x, 10%y)";
Debug.ShouldStop(4194304);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._txtcel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 57;BA.debugLine="lblkel.Initialize(\"lblkel\")";
Debug.ShouldStop(16777216);
main.mostCurrent._lblkel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("lblkel")));
 BA.debugLineNum = 58;BA.debugLine="lblkel.Text = \"Kelvin\"";
Debug.ShouldStop(33554432);
main.mostCurrent._lblkel.runMethod(true,"setText",RemoteObject.createImmutable(("Kelvin")));
 BA.debugLineNum = 59;BA.debugLine="Activity.AddView(lblkel,10%x, 20%y, 20%x, 10%y)";
Debug.ShouldStop(67108864);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._lblkel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 61;BA.debugLine="txtkel.Initialize(\"txtkel\")";
Debug.ShouldStop(268435456);
main.mostCurrent._txtkel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("txtkel")));
 BA.debugLineNum = 62;BA.debugLine="txtkel.InputType = txtkel.INPUT_TYPE_NONE";
Debug.ShouldStop(536870912);
main.mostCurrent._txtkel.runMethod(true,"setInputType",main.mostCurrent._txtkel.getField(true,"INPUT_TYPE_NONE"));
 BA.debugLineNum = 63;BA.debugLine="Activity.AddView(txtkel,55%x, 15%y, 20%x, 10%y)";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._txtkel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 65;BA.debugLine="lblfah.Initialize(\"lblfah\")";
Debug.ShouldStop(1);
main.mostCurrent._lblfah.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("lblfah")));
 BA.debugLineNum = 66;BA.debugLine="lblfah.Text = \"Fahrenheit\"";
Debug.ShouldStop(2);
main.mostCurrent._lblfah.runMethod(true,"setText",RemoteObject.createImmutable(("Fahrenheit")));
 BA.debugLineNum = 67;BA.debugLine="Activity.AddView(lblfah,10%x, 30%y, 20%x, 10%y)";
Debug.ShouldStop(4);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._lblfah.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 30)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 69;BA.debugLine="txtfah.Initialize(\"txtfah\")";
Debug.ShouldStop(16);
main.mostCurrent._txtfah.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("txtfah")));
 BA.debugLineNum = 70;BA.debugLine="txtfah.InputType = txtfah.INPUT_TYPE_NONE";
Debug.ShouldStop(32);
main.mostCurrent._txtfah.runMethod(true,"setInputType",main.mostCurrent._txtfah.getField(true,"INPUT_TYPE_NONE"));
 BA.debugLineNum = 71;BA.debugLine="Activity.AddView(txtfah,55%x, 25%y, 20%x, 10%y)";
Debug.ShouldStop(64);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._txtfah.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 73;BA.debugLine="lblrea.Initialize(\"lblrea\")";
Debug.ShouldStop(256);
main.mostCurrent._lblrea.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("lblrea")));
 BA.debugLineNum = 74;BA.debugLine="lblrea.Text = \"Reamur\"";
Debug.ShouldStop(512);
main.mostCurrent._lblrea.runMethod(true,"setText",RemoteObject.createImmutable(("Reamur")));
 BA.debugLineNum = 75;BA.debugLine="Activity.AddView(lblrea,10%x, 40%y, 20%x, 10%y)";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._lblrea.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 40)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 77;BA.debugLine="txtrea.Initialize(\"txtrea\")";
Debug.ShouldStop(4096);
main.mostCurrent._txtrea.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("txtrea")));
 BA.debugLineNum = 78;BA.debugLine="txtrea.InputType = txtrea.INPUT_TYPE_NONE";
Debug.ShouldStop(8192);
main.mostCurrent._txtrea.runMethod(true,"setInputType",main.mostCurrent._txtrea.getField(true,"INPUT_TYPE_NONE"));
 BA.debugLineNum = 79;BA.debugLine="Activity.AddView(txtrea,55%x, 35%y, 20%x, 10%y)";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._txtrea.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 35)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 82;BA.debugLine="btnOK.Initialize(\"btnOK\")";
Debug.ShouldStop(131072);
main.mostCurrent._btnok.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("btnOK")));
 BA.debugLineNum = 83;BA.debugLine="btnOK.Text = \"KONVERSI\"";
Debug.ShouldStop(262144);
main.mostCurrent._btnok.runMethod(true,"setText",RemoteObject.createImmutable(("KONVERSI")));
 BA.debugLineNum = 84;BA.debugLine="Activity.AddView(btnOK,10%x, 80%y, 80%x, 10%y)";
Debug.ShouldStop(524288);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._btnok.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,94);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 94;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 90;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnok_click() throws Exception{
try {
		Debug.PushSubsStack("btnOK_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("btnok_click")) return main.remoteMe.runUserSub(false, "main","btnok_click");
 BA.debugLineNum = 99;BA.debugLine="Sub btnOK_click";
Debug.ShouldStop(4);
 BA.debugLineNum = 101;BA.debugLine="cel = txtcel.Text";
Debug.ShouldStop(16);
main._cel = BA.numberCast(float.class, main.mostCurrent._txtcel.runMethod(true,"getText"));
 BA.debugLineNum = 102;BA.debugLine="kel = cel + 273";
Debug.ShouldStop(32);
main._kel = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {main._cel,RemoteObject.createImmutable(273)}, "+",1, 0));
 BA.debugLineNum = 103;BA.debugLine="fah = (9/5)*cel + 32";
Debug.ShouldStop(64);
main._fah = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(9),RemoteObject.createImmutable(5)}, "/",0, 0)),main._cel,RemoteObject.createImmutable(32)}, "*+",1, 0));
 BA.debugLineNum = 104;BA.debugLine="rea = (4/5)*cel";
Debug.ShouldStop(128);
main._rea = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(4),RemoteObject.createImmutable(5)}, "/",0, 0)),main._cel}, "*",0, 0));
 BA.debugLineNum = 106;BA.debugLine="txtkel.Text = kel";
Debug.ShouldStop(512);
main.mostCurrent._txtkel.runMethodAndSync(true,"setText",(main._kel));
 BA.debugLineNum = 107;BA.debugLine="txtfah.Text = fah";
Debug.ShouldStop(1024);
main.mostCurrent._txtfah.runMethodAndSync(true,"setText",(main._fah));
 BA.debugLineNum = 108;BA.debugLine="txtrea.Text = rea";
Debug.ShouldStop(2048);
main.mostCurrent._txtrea.runMethodAndSync(true,"setText",(main._rea));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Dim lblcel As Label";
main.mostCurrent._lblcel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim txtcel As EditText";
main.mostCurrent._txtcel = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim lblkel As Label";
main.mostCurrent._lblkel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim txtkel As EditText";
main.mostCurrent._txtkel = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim lblfah As Label";
main.mostCurrent._lblfah = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim txtfah As EditText";
main.mostCurrent._txtfah = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Dim lblrea As Label";
main.mostCurrent._lblrea = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim txtrea As EditText";
main.mostCurrent._txtrea = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Dim btnOK As Button";
main.mostCurrent._btnok = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Dim cel As Float, kel As Float, fah As Float, rea As Float";
main._cel = RemoteObject.createImmutable(0f);
main._kel = RemoteObject.createImmutable(0f);
main._fah = RemoteObject.createImmutable(0f);
main._rea = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}