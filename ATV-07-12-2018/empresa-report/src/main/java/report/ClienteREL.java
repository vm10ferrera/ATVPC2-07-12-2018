package report;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

import model.Cliente;

public class ClienteREL {
	private String path; // Caminho base

	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper

	// Recupera os caminhos para que a classe possa encontrar os relatórios
	public ClienteREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "report/";
		System.out.println(path);
		System.out.println(pathToReportPackage);
	}

	// Imprime/gera uma lista de Clientes
	public void imprimir(List<Cliente> sql) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Blank_A4.jrxml");
		
		System.out.println(report);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(sql));
		
        //Lembrar de criar a pasta rel
		JasperExportManager.exportReportToPdfFile(print, "C:/rel/Relatorio.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}
}
