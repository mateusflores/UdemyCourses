package application;

import entities.Contract;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scn = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        Integer numero = scn.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        String data = scn.next();
        scn.nextLine();
        System.out.print("Valor do contrato: ");
        Double valorContrato = scn.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        Integer numParcelas = scn.nextInt();

        scn.close();

        Contract contract;

        contract = new Contract(numero, sdf.parse(data), valorContrato);

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, numParcelas);

        contract.showInstallments();
    }
}