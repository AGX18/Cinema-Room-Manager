import java.util.Scanner;
public class Cinema {
    private static int noOfPurchasedTickets = 0;
//    private static int totalIncome = 0;
    private static int currentIncome = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row: ");
        int seats = scanner.nextInt(); // seats in each row
        char[][] seatArr = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < seats; j++){
                seatArr[i][j] = 'S';
            }
        }
        int totalSeats = rows * seats;

//        PrintSeats(seats, rows);
//        System.out.println();


        boolean done = false;
        while(!done){

            PrintChoices();
            switch (scanner.nextInt()) {
                case 1 -> PrintSeats(seatArr, seats, rows); // done
                case 2 -> BuyTicket(scanner, rows, seats, totalSeats, seatArr); // done
                case 3 -> printStatistics(rows, seats); // done
                case 0 -> done = true;
                default -> System.out.println("Wrong input!");
            }

        }

        //System.out.println();
        //PrintSeats(seats, rows);

        //totalIncome(totalSeats, rows, seats);
    }

    private static void totalIncome(int totalSeats, int rows, int seats) {
        int totalIncome;
        if(totalSeats < 60){
            totalIncome = totalSeats * 10;
        }
        else{
            totalIncome = (rows / 2) * seats * 10 + (rows - (rows / 2)) * seats * 8;
        }
        System.out.println("Total income: " + "$" + totalIncome);
    }

//    private static void PrintSeats(char[][] SeatArr,int seats, int rows, int row, int seat) {
//        // printing arrangement of seats
//        System.out.println("Cinema:");
//        System.out.print("  ");
//        for(int i = 1; i <= seats; i++){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for(int i = 1; i <= rows /* rows */; i++){
//            System.out.print(i + " ");
//            for(int j = 1; j <= seats /* rows */; j++){
//                System.out.print(SeatArr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


    private static void PrintSeats(char[][] seatArr,int seats, int rows) {
        // printing arrangement of seats
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int i = 1; i <= seats; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < rows /* rows */; i++){
            System.out.print(i+1 + " ");
            for(int j = 0; j < seats /* rows */; j++){
                System.out.print(seatArr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void BuyTicket(Scanner scanner, int rows, int seats, int totalSeats, char[][] seatArr)
    {
        System.out.println();
        int row;
        int seat;
        while (true) {
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();
            System.out.println();
            if (row > rows || seat > seats) {
                System.out.println("Wrong input!");

            }
            else if(seatArr[row - 1][seat - 1] == 'B')
            {
                System.out.println("That ticket has already been purchased!");
            }
            else {
//              System.out.println();
                noOfPurchasedTickets++;
                int price = (totalSeats < 60 || row <= rows / 2 ? 10 : 8);
                currentIncome += price;
                System.out.println("Ticket price: $" + (totalSeats < 60 || row <= rows / 2 ? 10 : 8));

                break;
            }
            System.out.println();
        }

        seatArr[row - 1][seat - 1] = 'B';

    }

    private static void PrintChoices()
    {
        System.out.println();
        System.out.print("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """);
    }

    private static void printStatistics (int rows, int seats)
    {
        System.out.println("Number of purchased tickets: " + noOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", (float) noOfPurchasedTickets / (rows * seats) * 100);
        System.out.println("Current income: $" + currentIncome);
        totalIncome(rows * seats, rows, seats);
    }
}