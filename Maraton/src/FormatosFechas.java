import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class FormatosFechas {

	public static SimpleDateFormat fecha;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendario = GregorianCalendar.getInstance();
		Date f = calendario.getTime();
		fecha =  new SimpleDateFormat("EEEEEEEEE, dd 'de' MMMMM 'de' yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("EEE, dd 'de' MMM'de' yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("yyyy'/'MM'/'dd");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("dd'/'MM'/'yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("MM'/'dd'/'yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("yyyy'/'MMM'/'dd");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("dd'/'MMM'/'yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("MMM'/'dd'/'yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("EEE, yyyy'/'MMM'/'dd");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("EEE, dd'/'MMM'/'yyyy");
		System.out.println(fecha.format(f));
		fecha =  new SimpleDateFormat("EEE, MMM'/'dd'/'yyyy");
		System.out.println(fecha.format(f));
	}

}
