import java.util.Scanner;

class tugasqueue {
    private static final int MAX_SIZE = 5;
    private int front, rear;
    private int[] queue;

    public LinearQueue() {
        front = -1;
        rear = -1;
        queue = new int[MAX_SIZE];
    }

    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Antrian penuh. Tidak bisa menambahkan elemen.");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear++;
            queue[rear] = item;
            System.out.println("Elemen " + item + " ditambahkan ke antrian.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong. Tidak ada elemen untuk dihapus.");
        } else {
            int removedItem = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Elemen " + removedItem + " dihapus dari antrian.");
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Isi Antrian:");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinearQueue linearQueue = new LinearQueue();

        int choice;
        do {
            System.out.println("Menu Antrian Linear:");
            System.out.println("1. Enqueue (Tambah Elemen)");
            System.out.println("2. Dequeue (Hapus Elemen)");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nilai yang akan ditambahkan ke antrian: ");
                    int enqueueValue = scanner.nextInt();
                    linearQueue.enqueue(enqueueValue);
                    break;
                case 2:
                    linearQueue.dequeue();
                    break;
                case 3:
                    linearQueue.display();
                    break;
                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
