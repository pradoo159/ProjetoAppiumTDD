package br.com.rsinet.hub_tdd.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rsinet.hub_tdd.testcase.Cadastro_TC;
import br.com.rsinet.hub_tdd.testcase.PesquisaPorCategoria_TC;
import br.com.rsinet.hub_tdd.testcase.PesquisaPorTexto_TC;

@RunWith(Suite.class)
@SuiteClasses({Cadastro_TC.class, PesquisaPorTexto_TC.class, PesquisaPorCategoria_TC.class})
public class TestRunner {
	
	@BeforeClass
	public static void iniciaReport() {
		ExtentReport.iniciaReport();
	}
	
	@AfterClass
	public static void fecharReport() {
		ExtentReport.fechaReport();
	}

}
