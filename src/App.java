import java.io.IOException;
import java.util.Scanner;

public class App {
    static boolean isLogin = false;
    static boolean run = true;

    private static User authenticate(String username, String password) {
        User user = User.getUsers().get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static void main(String arv[]) {
        User.addUser("admin", "123");
        Scanner sc = new Scanner(System.in);
        while (run) {
            System.out.println("1. Login");
            System.out.println("2. Tutup Aplikasi");
            int aksi = sc.nextInt();

            if (aksi == 1) {
                while (!isLogin) {
                    System.out.println("Silakan login");
                    System.out.print("Username : ");
                    String username = sc.next();
                    System.out.print("Password : ");
                    String password = sc.next();

                    User user = authenticate(username, password);

                    if (user != null) {
                        isLogin = true;
                        Akun.login(user);
                        System.out.println("Selamat datang " + Akun.getCurrentUser().getUsername());
                    } else {
                        System.out.println("Username atau password salah. Silakan coba lagi.");
                    }
                }
                run = false;
            } else {
                run = false;
            }

            sc.nextLine();

            if (isLogin) {
                System.out.print("\033[H\033[2J");

                Employee epv = new Employee();
                int i = 0;

                MainMenu obj1 = new MainMenu();
                obj1.menu();

                while (i < 5) {
                    System.out.print("\nPlease Enter choice : ");
                    i = Integer.parseInt(sc.nextLine());

                    switch (i) {
                        case 1: {
                            Employee ep = new Employee();
                            ep.createFile();

                            System.out.print("\033[H\033[2J");
                            obj1.menu();
                            break;
                        }
                        case 2: {
                            System.out.print("\nPlease Enter Employee's ID : ");
                            String s = sc.nextLine();
                            try {
                                epv.viewFile(s);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            System.out.print("\nPress Enter to Continue...");
                            sc.nextLine();
                            System.out.print("\033[H\033[2J");
                            obj1.menu();
                            break;
                        }
                        case 3: {
                            System.out.print("\nPlease Enter Employee's ID : ");
                            String s = sc.nextLine();
                            Employee epr = new Employee();
                            epr.removeFile(s);

                            System.out.print("\nPress Enter to Continue...");
                            sc.nextLine();
                            System.out.print("\033[H\033[2J");
                            obj1.menu();
                            break;
                        }
                        case 4: {
                            System.out.print("\nPlease Enter Employee's ID : ");
                            String I = sc.nextLine();
                            try {
                                epv.viewFile(I);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            Employee epu = new Employee();
                            System.out.print("Please Enter the detail you want to Update :");
                            System.out.print("\nFor Example :\n");
                            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
                            String s = sc.nextLine();
                            System.out.print("Please Enter the Updated Info : ");
                            String n = sc.nextLine();
                            try {
                                epu.updateFile(I, s, n);

                                System.out.print("\nPress Enter to Continue...");
                                sc.nextLine();
                                System.out.print("\033[H\033[2J");
                                obj1.menu();
                                break;
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }
                        case 5: {
                            Akun.logout();
                            System.out.println("Anda telah logout.");
                            run = true;
                            isLogin = false;
                            break;
                        }
                        case 6: {
                            CodeExit obj = new CodeExit();
                            obj.out();
                        }
                    }
                }
            }
        }
    }
}
