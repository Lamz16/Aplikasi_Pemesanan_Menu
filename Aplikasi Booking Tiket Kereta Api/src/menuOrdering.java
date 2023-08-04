public class menuOrdering {
    public static String[] orderMenu = new String[10];
    public static Integer[] totalAmount = new Integer[10];

    public static String[] listMenu = {"Croffle","Beef Bowl","Roti Bakar","Cinnamon Roll","Milk Tea","Sandwich","Smoothies","Potato Wedges","Pasta","Espresso","Americano","Cappucino","Caffe Latte"};
    public static Integer[] listPrice = {20000,31000,7000,22000,18000,23000,18000,11000,20000,18000,22000,24000,23000};

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
      viewShowMenu();
    }
    /**
     * Show list menu
     */
    public static void showMenu(){
        System.out.println("Menu Kafe As Salam");
        for (var i = 0; i < listMenu.length && i <listPrice.length ; i++ ){
            var lMenu = listMenu[i];
            var price = listPrice[i];
            var no = i + 1;
            System.out.println(no + ". " + lMenu + "\t  Rp. " + price);
        }
    }

    public static void testShowMenu(){
        showMenu();
    }

    /**
     * View show your order and total amount
     */
    public static void showYourOrder(){
        System.out.println("Total Pesanan Mu");
        for (var i = 0; i < orderMenu.length; i++ ){
            var lMenu = orderMenu[i];
            var amount = totalAmount[i];
            var no = i + 1;
            if (lMenu != null) {
                System.out.println(no + ". " + lMenu + " " + amount);
            }
        }
        showTotalPayment();
    }

    public static void showTotalPayment(){
        var totalPay = 0;
        for (var i = 0; i < totalAmount.length; i++){
            if (totalAmount[i] != null){
            totalPay += totalAmount[i];}
        }
        System.out.println("Jumlah yang harus di bayar Rp. "+ totalPay +"\n\n");
    }

    /**
     * Add menu
     */
    public static void addOrder(Integer order){
        var isFull = true;
        //pengecekan apakah terdapat array yang tersedia di dalam array orderMenu
        for (var i = 0; i < orderMenu.length || i < totalAmount.length; i++){
            if(orderMenu[i]==null || totalAmount==null){
                isFull = false;
                break;
            }
        }
        if (isFull){
            var temp  = orderMenu;
            orderMenu = new String[orderMenu.length * 2];
            var temp2 = totalAmount;
            totalAmount = new Integer[totalAmount.length * 2];

            for (var i = 0; i < temp.length || i < temp2.length; i++){
                orderMenu[i] = temp[i];
                totalAmount[i] = temp2[i];
            }
        }

        //add new chart
        for(var i = 0 ; i < orderMenu.length && i < totalAmount.length; i++){
            if (orderMenu[i]==null && totalAmount[i]==null){
                orderMenu[i]= listMenu[order-1];
                totalAmount[i]=listPrice[order-1];
                break;
            }
        }
    }

    public static void testAddOrder(){
        showMenu();
        addOrder(1);
        addOrder(12);
        showYourOrder();
    }

    /**
     * Remove order
     */
    public static boolean removeOrder(Integer order){
        if ((order -1 ) >= orderMenu.length){
            return false;
        } else if ( orderMenu[order -1] == null) {
            return false;
        }else {
            for (var i = (order - 1); i < orderMenu.length; i++){
                if (i == (orderMenu.length - 1)){
                    orderMenu[i] = null;
                    totalAmount[i] = null;
                }else {
                    orderMenu[i] = orderMenu[i+1];
                    totalAmount[i] = totalAmount[i+1];

                }
            }
            return true;
        }
    }
    public static void testRemoveOrder(){
        addOrder(2);
        addOrder(3);
        showYourOrder();
        removeOrder(2);
        showYourOrder();

    }

    /**
     * Input
     */

    public static String input(String info){
        System.out.print(info+ " : ");
        String data = scanner.nextLine();
        return data;
    }


    public static void testInput(){
//        var data = inputMenu( ": ");
//        System.out.println("Pesanan mu "+ data);
    }

    /**
     * View Show Menu
     */
    public static void viewShowMenu(){
        while (true) {
            showMenu();
            System.out.println("1. Pesan menu");
            System.out.println("2. Pesanan mu");
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddOrder();
            } else if (input.equals("2")) {
                viewYourOrder();
            }else if(input.equals("3")){
                showYourOrder();
                break;
            }else {
                System.out.println("Tidak tersedia");
            }
        }
    }
    public static void testViewShowMenu(){
        viewShowMenu();
    }

    /**
     * View add menu
     */
    public static void viewAddOrder(){
        while (true) {
            System.out.println("Pesan Menu Pilihan mu");
            showMenu();
            var input = input("Masukkan menu (Tekan x jika selesai)");

            if (input.equals("1")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("2")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("3")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("4")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("5")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("6")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("7")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("8")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("9")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("10")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("11")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("12")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("13")) {
                addOrder(Integer.valueOf(input));
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("pilihan tidak tersedia");
            }
        }
    }
    public static void testViewAddOrder(){
        viewAddOrder();
    }

    /**
     * View your Menu and remove order from your menu
     */
    public static void viewYourOrder(){
        while (true){
            showYourOrder();
            var input = input("Pilih d untuk menghapus menu dari pesanan mu dan tekan x untuk keluar atau selesai ");
            if (input.equals("x")){
                break;
            }else if(input.equals("d")){
                while (true) {
                    showYourOrder();
                    var remove = input("Masukkan nomor menu yang akan dihapus (tekan x untuk keluar)");
                    if (remove.equals("x")){
                        break;
                    }else {
                        removeOrder(Integer.valueOf(remove));
                        System.out.println("Berhasil menghapus menu dari pesanan mu");
                    }
                }
            }

        }
    }

    public static void testViewYourOrder(){
        viewYourOrder();
    }
}