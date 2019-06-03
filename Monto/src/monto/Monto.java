package monto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Monto {

public static String prefijod(int x)
{String cadena;
    
    switch(x){
	
	case 2:{cadena = "VEINTE";}break;
	case 3:{cadena = "TREINTA";}break;
	case 4:{cadena = "CUARENTA";}break;
	case 5:{cadena = "CINCUENTA";}break;
	case 6:{cadena = "SESENTA";}break;
	case 7:{cadena = "SETENTA";}break;
	case 8:{cadena = "OCHENTA";}break;
	case 9:{cadena = "NOVENTA";}break;
	case 10:{cadena = "CIEN";}break;
	case 50:{cadena = "QUINI";}break;
	case 70:{cadena = "SETECI";}break;
	case 90:{cadena= "NOVECI";}break;
        default: cadena="";
}
return cadena;
}



public static String unidades(int x)
{String cadena;
  switch(x){
        case 1:{cadena = "UNO";}break;
	case 2:{cadena = "DOS";}break;
	case 3:{cadena = "TRES";}break;
	case 4:{cadena = "CUATRO";}break;
	case 5:{cadena = "CINCO";}break;
	case 6:{cadena = "SEIS";}break;
	case 7:{cadena = "SIETE";}break;
	case 8:{cadena = "OCHO";}break;
	case 9:{cadena = "NUEVE";}break;
        default: cadena="";
	}

return cadena;
}


public static String decenas(int x)
{int y;
String cadena = "";
String cad;
switch(x){
	case 10:{cadena = "DIEZ";}break;
	case 11:{cadena = "ONCE";}break;
	case 12:{cadena = "DOCE";}break;
	case 13:{cadena = "TRECE";}break;
	case 14:{cadena = "CATORCE";}break;
	case 15:{cadena = "QUINCE";}break;
}
if((x>15)&&(x<20))

{
	cadena= "DIECI";
	x=x%10;
}

if((x%10>0)&&(x>19)&&(x<100))

{

	cadena = prefijod(x/10) + " Y ";
	x=x%10;
}

if((x%10==0)&&(x>19)&&(x<100))

{
cadena = prefijod(x/10);
}
cad = cadena + unidades(x);

return cad;

}


public static String centenas(int x){
	int y;
        String cadena ="";
        String cad;
        
	if(((x>=200)&&(x<500))||((x>=600)&&(x<700))||((x>=800)&&(x<900)))
        {   
	
    	cadena = unidades(x/100) + "CIENTOS ";
        
	}
	
	
	if(((x>=500)&&(x<600))||((x>=700)&&(x<800))||((x>=900)&&(x<1000)))
	{
		y=x/100;
		y=Math.round(y*10);
		cadena= prefijod(y) + "ENTOS ";
        
	}
	
	if((x>100)&&(x<200))
	{   y=x/100;
		y=Math.round(y*10);
		cadena = prefijod(y) + "TO ";

	}
	if(x==100)
	{
		y=x/100;
		y=Math.round(y*10);
		cadena = prefijod(y);
		
	}
	
	cad=cadena + decenas(x%100);
	
	return cad;
}	



public static String millares(int x)
{    String cadena=new String();
     
	int y;
	int z;
        
	if((x>1000)&&(x<1000000))
	{
		y=x/1000;
		z=x%1000;
		cadena= centenas(y) + " MIL "+ centenas(z);
		
	}
	
	if(x==1000)
	{
		
		cadena = "MIL";
	}
	
	
	if(x<1000)
	{
		
	cadena=centenas(x);	
	}
        return cadena;
}

public static String millones(int x){
	int y;
	int z;
        String cadena="";
	if((x>=2000000)&&(x<1000000000))
	{
		y=x/1000000;
		z=x%1000000;
		cadena= millares(y) + " MILLONES " + millares(z);
		
	}
	
	if((x>=1000000)&&(x<2000000))
	{
		z=x%1000000;
	cadena= "UN MILLON" + millares(z);
	}
	
	if(x<1000000)
	{
		cadena= millares(x);
	}
	 return cadena;
}


public static String centecimas(int v){
   String cadena= "";	
    if(v%10>0){
	
	 cadena=decenas(v) + " CENTESIMAS";
		
	}
    
    return cadena;
}
	


public static String con(int e,int f){
String cadena="";
if((e>0)&&(f>0))
{
   cadena=" CON "; 
}

return cadena;
}




public static String decimas(int u){
String cadena; 
if((u%10==0)&&(u>0)){
	 
cadena= unidades(u/10)+ " DECIMAS";}

else
{cadena=centecimas(u);}

return cadena;
}


public static String separacion(float d,int n,int m) throws ParseException
{int i;
int f;
float y;
String cadena= new String();
i=(int) d;	
f=recortarDecimal(d,n);
i=recortarEntero2(i,m);

if((i<100000000)&&(f<100))
{cadena= millones(i)+con(i,f)+decimas(f);


}
else
{System.out.print("\nNumero erroneo");}
 
return cadena;
}


public static int largo(int num){
int digitos = 0;
while(num !=0)
 {
   num = num/10;
   digitos++;
 }
return digitos;
}

 /*Funcion para recortar entero derecha a izquierda  */

public static int recortarEntero (int num,int n){
int hn;
hn=(int) (num%(Math.pow(10,n)));
System.out.println(hn);
return hn;
}

public static int recortarDecimal(float d,int n){
 int f=0;
 int e;
 e=(int) d/1;
 if(n==2){
 f=(int) Math.round((d-e)*100);}
 else if (n==1) {   
 f=Math.round((d-e)*100);
 f=(int) (f/10);
 }
 
 System.out.println(f);   
 return f;
}



  /*Funcion para recortar un numero de n decimales en un entero 
El problema al restar el numero de entrada con la parte entera ,deja basura en el resultado
por lo tanto inhabilita esta funcion 
*/

public static float recortarDecimal2 (float d,int n) throws ParseException{
 NumberFormat myNumForm = NumberFormat.getInstance(Locale.FRENCH);
 float n2;   
 String j;
 String cadena="#.";
 while(n !=0){
 cadena=cadena + "0";
 n=n-1;
 }
 DecimalFormat df = new DecimalFormat(cadena);
 j=df.format(d);
double myParsedFrenchNumber = (double) myNumForm.parse(j);
n2=(float) myParsedFrenchNumber;
System.out.println(n2);
return n2;
}

 /*Funcion para recortar entero izquierda a derecha  */
public static int recortarEntero2 (int num,int n){
int hn;
int lar;
lar= largo(num);
hn=(int) (num/(Math.pow(10,lar - n)));
System.out.println(hn);
return hn;
}

public static void main(String [] args) throws ParseException{
float d;
int n,m;
String un,fin;
Scanner obj;
System.out.print("Digite un numero :");
obj=new Scanner(System.in);
d=obj.nextFloat();
System.out.print("Digite los decimales deseados,menores o iguales a 2 :");
obj=new Scanner(System.in);
n=obj.nextInt();
System.out.print("Digite los enteros deseados :");
obj=new Scanner(System.in);
m=obj.nextInt();
System.out.print("Digite la unidad deseada :");
obj=new Scanner(System.in);
un=obj.nextLine();
fin=separacion(d,n,m)+" "+un;
System.out.println(fin);
}













}