package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		
		//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// instanciando uma data local (sistema);
		LocalDate d01 = LocalDate.now(); // .now() é um método estático do LocalDate;
		// instanciand uma data local com hora local (sistema)
		LocalDateTime d02 = LocalDateTime.now();
		// instanciando uma data hora global (GMT)
		Instant d03 = Instant.now();
		
		// transformando uma ISO - 8601 em dataHora
		LocalDate d04 = LocalDate.parse("2004-09-01");
		LocalDateTime d05 = LocalDateTime.parse("2004-09-01T16:00:00");
		Instant d06 = Instant.parse("2004-09-01T16:00:00z");
		Instant d07 = Instant.parse("2004-09-01T16:00:00-03:00");
		
		/* 
		 *  ISO 8601 - (ano-mes-data)
		 */
		
		// LocalDate aceita uma sobrecarga que passa como paremetro um formato de data
		LocalDate d08 = LocalDate.parse("01/09/2004", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("01/09/2004 16:50:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		
		// separando ano, mês e dia
		LocalDate d10 = LocalDate.of(2024, 07, 01);
		// separando ano, mês, dia, hora e minuto
		LocalDateTime d11 = LocalDateTime.of(2024, 07, 01, 16, 50);
		
		
		System.out.println("d01=  " + d01);
		System.out.println("d02=  " + d02);
		System.out.println("d03=  " + d03);
		System.out.println("d04=  " + d04);
		System.out.println("d05=  " + d05);
		System.out.println("d06=  " + d06);
		System.out.println("d07=  " + d07);
		System.out.println("d08=  " + d08);
		System.out.println("d09=  " + d09);
		System.out.println("d10=  " + d10);
		System.out.println("d11=  " + d11);
		
		//transformando ISO8601 para uma string formatada
		System.out.println("d10 formatado= " + d10.format(fmt1));
		System.out.println("d10 formatado= " + fmt1.format(d10));
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println("d11 formatado= " + d11.format(fmt2));
		
		// Para formatar uma hora global que está no formato ISO8601 para uma String
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		// .withZone() temos que passar o time zone desejável
		// ZoneId.systemDefault() é um método estático para pegar o time zone do sistema do usário
		Instant d12 = Instant.now();
		System.out.println("d12 formatado= " + fmt3.format(d12));
		// Instant não possui o metodo format, por isso temos que chamar DateTimeFormatter para
		
		//Tranformando uma hora global em uma hora local
		// ZoneId.getAvailableZonesIds() retorna todos os times zones disponíveis
		Instant d13 = Instant.parse("2022-07-10T01:30:26Z");
		LocalDateTime d14 = LocalDateTime.ofInstant(d13, ZoneId.systemDefault());
		LocalDateTime d15 = LocalDateTime.ofInstant(d13, ZoneId.of("Portugal"));
		System.out.println("d14= " + d14.format(fmt2));
		System.out.println("d15= " + d15.format(fmt2));
		
		// Pegar o dados de uma hora local
		LocalDate d16 = LocalDate.parse("2024-07-02");
		LocalDateTime d17 = LocalDateTime.parse("2024-07-02T10:30:26");
		System.out.println("d16 dia = " + d16.getDayOfMonth());
		System.out.println("d16 mes = " + d16.getMonthValue());
		System.out.println("d16 mes = " + d16.getYear());
		System.out.println("d17 horas = " + d17.getHour());
		System.out.println("d17 minutos = " + d17.getMinute());
		System.out.println("d17 segundos = " + d17.getSecond());

		// Calculo com data e hora
		LocalDate passWeekD16 = d16.minusWeeks(1);
		LocalDate nextWeekd16 = d16.plusDays(7);
		System.out.println("d16= " + d16.format(fmt1));
		System.out.println("passWeekD16 = " + passWeekD16.format(fmt1));
		System.out.println("nextWeekD16 = " + nextWeekd16.format(fmt1));
		
		LocalDateTime passWeekD17 = d17.minusHours(5);
		LocalDateTime nextWeekd17 = d17.minusMinutes(60);
		System.out.println("d17= " + d17.format(fmt2));
		System.out.println("passWeekD17 = " + passWeekD17.format(fmt2));
		System.out.println("nextWeekD17 = " + nextWeekd17.format(fmt2));
		
		Instant passWeekD13 = d13.minus(7, ChronoUnit.DAYS);
		Instant nextWeekD13 = d13.plus(7, ChronoUnit.DAYS);
		System.out.println("passWeekD13 = " + fmt3.format(passWeekD13));
		System.out.println("nextWeekD13 = " + fmt3.format(nextWeekD13));
		
		// Calculando a duranção entre datas horas
		Duration d18 = Duration.between(passWeekD13, d13);
		System.out.println("d18= " + d18.toDays());
		
		// LocalDate não suporta, então tem que converter ele para LocalDateTime
		Duration d19 = Duration.between(passWeekD16.atTime(0, 0), d16.atStartOfDay());
		System.out.println("d19= " + d19.toDays());
	}

}
