package br.com.rsinet.hub_tdd.util;

public class Data {
	
	public static String dadoPesquisaValida() throws Exception {
		return ExcelUtils.getCellData(1, 0);
	}

	public static String dadoMouseValido() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}
	
	public static String dadoMouseValido2() throws Exception {
		return ExcelUtils.getCellData(2, 1);
	}
	
	public static String dadoPesquisaInvalida() throws Exception {
		return ExcelUtils.getCellData(2, 0);
	}
	
	public static String usuarioCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 0);
	}
	
	public static String emailCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}
	
	public static String senhaCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 2);
	}
	
	public static String nomeCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 3);
	}
	
	public static String sobrenomeCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 4);
	}
	
	public static String paisCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 5);
	}
	
	public static String estadoCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 6);
	}
	
	public static String enderecoCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 7);
	}
	
	public static String cidadeCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 8);
	}
	
	public static String cepCadastro() throws Exception {
		return ExcelUtils.getCellData(1, 9);
	}
	
}
