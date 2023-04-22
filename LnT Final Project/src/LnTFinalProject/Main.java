package LnTFinalProject;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
	 static ArrayList<String[]> daftarMenu = new ArrayList<>();
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        
	        int pilihan = 0;
	        do {
	        	System.out.println("Option");
	        	System.out.println("1. Insert Menu Baru");
	        	System.out.println("2. View Menu");
	        	System.out.println("3. Update Menu");
	        	System.out.println("4. Delete Menu");
	        	System.out.print(">> ");
	        	pilihan = input.nextInt();
	        	switch(pilihan) {
	        		case 1:
	        			String[] dataMenu = buatMenuBaru();
	                    daftarMenu.add(dataMenu);
	                    System.out.println("Menu baru berhasil ditambahkan!");
	                    break;
	        		case 2:
	        			tampilkanDaftarMenu();
	        			break;
	        		case 3:
	        			updateMenu();
	                    break;
	        		case 4:
	        			deleteMenu();
	        		    break;
	        	}
	        }while(pilihan != 4);
	}
	 public static String[] buatMenuBaru() {
	        Scanner input = new Scanner(System.in);
	        Random rand = new Random();
	        String[] dataMenu = new String[4];

	        int angkaAcak = rand.nextInt(1000);

	        String kodeAcak = String.format("%03d", angkaAcak);

	        String kodeMenu = "PD-" + kodeAcak;

	        System.out.print("Masukkan Nama Menu: ");
	        String namaMenu = input.nextLine();

	        System.out.print("Masukkan Harga Menu: ");
	        int hargaMenu = input.nextInt();

	        System.out.print("Masukkan Stok Menu: ");
	        int stokMenu = input.nextInt();

	        dataMenu[0] = kodeMenu;
	        dataMenu[1] = namaMenu;
	        dataMenu[2] = String.valueOf(hargaMenu);
	        dataMenu[3] = String.valueOf(stokMenu);

	        return dataMenu;
	    }
	 public static void tampilkanDaftarMenu() {
		 System.out.printf("| %-15s | %-20s | %-15s | %-15s |\n", "Kode Menu", "Nama Menu", "Harga Menu", "Stok Menu");
	        if (daftarMenu.isEmpty()) {
	            System.out.println("|                      Belum ada menu yang dibuat                      |");
	        } else {
	            for (String[] dataMenu : daftarMenu) {
	                System.out.printf("| %-15s | %-20s | %-15s | %-15s |\n", dataMenu[0], dataMenu[1], dataMenu[2], dataMenu[3]);
	            }
	        }
	        System.out.println();
	    }
	 
	  public static void updateMenu() {
	        Scanner input = new Scanner(System.in);
	        Scanner input2 = new Scanner(System.in);

	        tampilkanDaftarMenu();

	        System.out.print("Masukkan kode menu yang akan diubah: ");
	        String kodeMenu = input.nextLine();

	        int indexMenu = -1;
	        for (int i = 0; i < daftarMenu.size(); i++) {
	            if (daftarMenu.get(i)[0].equals(kodeMenu)) {
	                indexMenu = i;
	                break;
	            }
	        }

	        if (indexMenu == -1) {
	            System.out.println("Kode menu tidak ditemukan. Silakan coba lagi.");
	            return;
	        }

	        System.out.println("Pilih atribut yang akan diubah:");
	        System.out.println("1. Nama Menu");
	        System.out.println("2. Harga Menu");
	        System.out.println("3. Stok Menu");
	        System.out.print(">> ");
	        int pilihanAtribut = input.nextInt();

	        switch (pilihanAtribut) {
	        	case 1:
	        		System.out.print("Masukkan nama baru: ");
	                String namaBaru = input2.nextLine();
	                daftarMenu.get(indexMenu)[1] = String.valueOf(namaBaru);
	                System.out.println("Nama menu berhasil diubah!");
	                break;
	            case 2:
	                System.out.print("Masukkan harga baru: ");
	                int hargaBaru = input.nextInt();
	                daftarMenu.get(indexMenu)[2] = String.valueOf(hargaBaru);
	                System.out.println("Harga menu berhasil diubah!");
	                break;
	            case 3:
	                System.out.print("Masukkan stok baru: ");
	                int stokBaru = input.nextInt();
	                daftarMenu.get(indexMenu)[3] = String.valueOf(stokBaru);
	                System.out.println("Stok menu berhasil diubah!");
	                break;
	            default:
	                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
	                break;
	        }
	        System.out.println();
	    }
	  
	  public static void deleteMenu() {
		    Scanner input = new Scanner(System.in);

		    tampilkanDaftarMenu();

		    System.out.print("Masukkan kode menu yang akan dihapus: ");
		    String kodeMenu = input.nextLine();

		    int indexMenu = -1;
		    for (int i = 0; i < daftarMenu.size(); i++) {
		        if (daftarMenu.get(i)[0].equals(kodeMenu)) {
		            indexMenu = i;
		            break;
		        }
		    }

		    if (indexMenu == -1) {
		        System.out.println("Kode menu tidak ditemukan. Silakan coba lagi.");
		        return;
		    }

		    System.out.print("Anda yakin ingin menghapus menu " + daftarMenu.get(indexMenu)[1] + " (Y/N)? ");
		    String konfirmasi = input.nextLine();

		    if (konfirmasi.equalsIgnoreCase("Y")) {
		        daftarMenu.remove(indexMenu);
		        System.out.println("Menu berhasil dihapus!");
		    } else {
		        System.out.println("Penghapusan menu dibatalkan.");
		    }
		    System.out.println();
		}
}
