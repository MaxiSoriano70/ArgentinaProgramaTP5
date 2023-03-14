import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import modelos.Compra;
import modelos.Item;
import modelos.Producto;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Leer un archivo*/
		try {
			Compra carrito=new Compra();
			int i=0;
			for(String linea:Files.readAllLines(Paths.get("src\\items\\items.txt"))) {
				//System.out.println(linea);
				String nombre=linea.split(";")[0];
				int cantidad=Integer.parseInt(linea.split(";")[1]);
				double precio=Double.parseDouble(linea.split(";")[2]);
				Producto prod=new Producto(nombre,precio);
				Item item=new Item(prod,cantidad);
				carrito.getItems()[i]=item;
				i++;
				System.out.println("Total de "+prod.getNombre()+": "+item.calcularTotal());
			}
			System.out.println("Total de la compra: "+carrito.calcularTotalCompra());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
