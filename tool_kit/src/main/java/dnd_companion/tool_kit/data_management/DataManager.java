package dnd_companion.tool_kit.data_management;

import java.io.*;
import java.nio.file.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataManager
{
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String to_snake_case(String input) {
        return (input == null) ? null : input.toLowerCase().replace(" ", "_");
    }
	public static boolean check_dir_existance(String file_path) {
		Path directory = Paths.get(file_path);

        if (Files.exists(directory) && Files.isDirectory(directory)) {
            System.out.println("Directory found");
            return true;
        } else {
            System.out.println("Directory not found");
            return false;
        }
	}
	
	public static boolean save(Data data) {
		try {
			String file_path = String.format("data/%s/%s.json", data.collection(), to_snake_case(data.name()));
			File file = new File(file_path);
			mapper.writeValue(file, data);
			
			System.out.println("Data saved successfully");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean retrive(Object object) {
		try {
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

//public class Main {
//    public static void main(String[] args) {
//        // Criação do objeto Endereco e Pessoa
//        Endereco endereco = new Endereco();
//        endereco.setRua("Rua das Flores");
//        endereco.setCidade("São Paulo");
//
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("João");
//        pessoa.setIdade(30);
//        pessoa.setEndereco(endereco);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            // Salvar o arquivo JSON no diretório 'dados'
//            File arquivo = new File("dados/pessoa.json");
//            objectMapper.writeValue(arquivo, pessoa);
//            System.out.println("Arquivo JSON salvo com sucesso na pasta 'dados'!");
//
//            // Modificar o objeto Pessoa
//            pessoa.setNome("Maria");
//            pessoa.setIdade(25);
//
//            // Sobrescrever o arquivo JSON com o novo conteúdo
//            objectMapper.writeValue(arquivo, pessoa);
//            System.out.println("Arquivo JSON sobrescrito com sucesso na pasta 'dados'!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}