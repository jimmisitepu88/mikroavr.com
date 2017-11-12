/*
 * 74hc595.c
 *
 * Created: 9/13/2017 11:32:26 PM
 * Author : Jimmi Sitepu
 */ 

#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>

#define DATA PORTD4
#define CLOCK PORTD0
#define LATCH PORTD1

#define LATCH_0 PORTD = PORTD & ~(1<<PD1)
#define LATCH_1 PORTD = PORTD | (1<<PD1)

#define CLOCK_0 PORTD = PORTD & ~(1<<PD0)
#define CLOCK_1 PORTD = PORTD | (1<<PD0)

#define DATA_0 PORTD = PORTD & ~(1<<PD4)
#define DATA_1 PORTD = PORTD | (1<<PD4)


void displaySegment(uint8_t POS1);
void shiftOut(uint8_t val);

int main(void)
{
    /* Replace with your application code */
	
	DDRD = (1<<DDD5)|(1<<DDD4)|(1<<DDD1)|(1<<DDD0);//SET SEBAGAI OUTPUT
	PORTD = (0<<PORTD5)|(0<<PORTD4)|(0<<PORTD1)|(0<<PORTD0);
		
	
    while (1) 
    {
		displaySegment(0b01111111);
		_delay_ms(1000);
		displaySegment(0x00);
		_delay_ms(1000);
    }
}

void shiftOut(uint8_t val){
	uint8_t i;
	uint8_t data;
	for (i = 0; i < 8; i++)
	{
		data = val & (1<<(7-i));
		if (data == 0)
		{
			DATA_0;
		}
		else{
			DATA_1;
		}
		CLOCK_1;
		CLOCK_0;
		
	}
}

void displaySegment(uint8_t	POS1){
	
	LATCH_0;
	shiftOut(POS1);
	shiftOut(POS1);
	shiftOut(POS1);
	shiftOut(POS1);
	LATCH_1;
}

