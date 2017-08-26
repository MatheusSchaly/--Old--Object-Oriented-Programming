package br.univali.kob.poo1.aula03;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Testes de herança: Employee é uma subclasse de Person.
 *
 * @author Marcello Thiry
 */
public class EmployeeInheritanceTest {

    /**
     * Caso de teste: instanciar, popular e mostrar um empregado.
     * <p>
     * Note que foram passadas Strings para o construtor do BigDecimal.
     * Esta é uma recomendação da própria documentação do Java para
     * evitar problemas de precisão na hora de criar o valor.
     * <p>
     * Outra novidade é a utilização do NumberFormat para formatar
     * valores financeiros. Veja mais detalhes sobre NumberFormat em:
     * <p>
     * <a href="https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html">
     * https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html</a>
     * 
     * <p>
     * Verifique também se os cálculos estão corretos.
     */
    private void createEmployee() {
        System.out.println("test case: createEmployee");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Employee employee = new Employee(100, "Peter Quill", LocalDate.parse("15/01/1976", format), LocalDate.parse("20/09/2002", format), 40, new BigDecimal("20.7"));

        String output = "[Employee %d]\n" +
                "name: %s\n" +
                "age: %d\n" +
                "years of service: %d\n" +
                "hourly rate: %s\n" +
                "hours per work week: %d\n" +
                "regular salary: %s\n" +
                "weekly salary (considering 0 absent hours): %s\n" +
                "weekly salary (considering 5 absent hours): %s\n" +
                "weekly salary (considering 10 absent hours): %s\n\n";
        
        System.out.printf(output,
            employee.getId(), 
            employee.getName(), 
            employee.getAge(),
            employee.getYearsOfService(),
            NumberFormat.getCurrencyInstance().format(employee.getHourlyRate()),
            employee.getHoursPerWorkWeek(),
            NumberFormat.getCurrencyInstance().format(employee.getRegularWeekSalary()),
            NumberFormat.getCurrencyInstance().format(employee.getWeekPayment(0)),
            NumberFormat.getCurrencyInstance().format(employee.getWeekPayment(5)),
            NumberFormat.getCurrencyInstance().format(employee.getWeekPayment(10)));
    }

    /**
     * Carga de teste: executa todos os casos de teste.
     */
    public void run() {
        System.out.printf("\n\n\n******* aula02: EmployeeInheritanceTest ******** \n\n");
        createEmployee();
    }
    
}
