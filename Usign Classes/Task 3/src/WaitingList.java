import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class WaitingList extends CruiseShip_Task_3{

    public static void main(String[] args) {
        int enroll;

        // Creating Queue using the LinkedList class
        Queue<Integer> passenger = new LinkedList<>();

        // enqueue
        // insert element at the rear of the queue
        passenger.offer(1);
        passenger.offer(2);
        passenger.offer(3);
        passenger.offer(4);
        passenger.offer(5);
        passenger.offer(6);
        passenger.offer(7);
        passenger.offer(8);
        passenger.offer(9);
        passenger.offer(10);
        passenger.offer(11);
        passenger.offer(12);
        passenger.offer(13);
        passenger.offer(14);
        passenger.offer(15);
        passenger.offer(16);
        passenger.offer(17);
        passenger.offer(18);
        passenger.offer(19);
        passenger.offer(20);
        passenger.offer(21);
        passenger.offer(22);
        passenger.offer(23);
        passenger.offer(34);
        passenger.offer(25);
        passenger.offer(26);
        passenger.offer(27);
        passenger.offer(28);
        passenger.offer(29);
        passenger.offer(30);
        passenger.offer(31);
        passenger.offer(32);
        passenger.offer(33);
        passenger.offer(34);
        passenger.offer(35);
        passenger.offer(36);


        Scanner waitingList = new Scanner(System.in);
        System.out.println("Select the options,\n");
        System.out.println("1. Display passenger waiting list");
        System.out.println("2. Remove passenger from waiting list");
        System.out.println("Select the options,");
        enroll = waitingList.nextInt();

        if (enroll == 1) {
            System.out.println("Ship Boarding Waiting List\n");
            System.out.println("Queue: " + passenger);
        }
        if (enroll == 2) {
            System.out.println("Removing Passenger\n");
            // dequeue
            // delete element from the front of the queue
            int removedNumber = passenger.poll();
            System.out.println("Removed Passenger: " + removedNumber);

            System.out.println("Queue after deletion: " + passenger);
        }
    }
}


//import java.util.LinkedList;
//        import java.util.Queue;
//        import java.util.Scanner;
//
//class WaitingList extends CruiseShip_Task_3{
//
//    public static void main(String[] args) {
//        while (true) {
//            int enroll;
//
//            // Creating Queue using the LinkedList class
//            Queue<Integer> passenger = new LinkedList<>();
//
//
//            Scanner waitingList = new Scanner(System.in);
//            System.out.println("Select the options,\n");
//            System.out.println("1. Add passenger waiting list");
//            System.out.println("2. Display passenger waiting list");
//            System.out.println("3. Remove passenger from waiting list");
//            System.out.println("4. Exit");
//            System.out.println("Select the options,");
//            enroll = waitingList.nextInt();
//
//
//            // enqueue
//            // insert element at the rear of the queue
//            passenger.offer(1);
//            passenger.offer(2);
//            passenger.offer(3);
//
//            if (enroll == 1) {
//                String add;
//                Scanner addPassanger = new Scanner(System.in);
//                System.out.println("Add Passenger\n");
//                add = addPassanger.next();
//
//            }
//            if (enroll == 2) {
//                System.out.println("Ship Boarding Waiting List\n");
//                System.out.println("Queue: " + passenger);
//            }
//            if (enroll == 3) {
//                System.out.println("Removing Passenger\n");
//                // dequeue
//                // delete element from the front of the queue
//                int removedNumber = passenger.poll();
//                System.out.println("Removed Passenger: " + removedNumber);
//
//                System.out.println("Queue after deletion: " + passenger);
//            }
//            if (enroll == 4) {
//                System.exit(0);
//            }
//        }
//    }
//}