package JavaOOP.Creativity;

import java.util.LinkedList;
import java.util.Queue;
// C-2.28 Write a set of Java classes that can simulate an Internet application in which one
// party, Alice, is periodically creating a set of packets that she wants to send to
// Bob. An Internet process is continually checking if Alice has any packets to
// send, and if so, it delivers them to Bob’s computer; Bob is periodically checking
// if his computer has a packet from Alice, and if so, he reads and deletes it.
class Packet {
    String message;
    public Packet(String message) {
        this.message = message;
    }
}

class Alice {
    Queue<Packet> packets = new LinkedList<>();

    public void createPacket(String message) {
        Packet packet = new Packet(message);
        packets.add(packet);
    }

    public Packet getPacket() {
        return packets.poll();
    }
}

class Bob {
    public void receivePacket(Packet packet) {
        readPacket(packet);
    }

    private void readPacket(Packet packet) {
        System.out.println("Bob reads: " + packet.message);
    }
}

class Internet {
    public void checkAndDeliver(Alice alice, Bob bob) {
        Packet packet = alice.getPacket();
        if (packet != null) {
            bob.receivePacket(packet);
        }
    }
public static void main(String[] args) {
        Alice alice = new Alice();
        Bob bob = new Bob();
        Internet internet = new Internet();

        // Alice creates packets periodically
        alice.createPacket("Hello Bob!");
        alice.createPacket("How are you?");

        // Internet process checks and delivers packets from Alice to Bob
        internet.checkAndDeliver(alice, bob);
        internet.checkAndDeliver(alice, bob);

        // Bob checks and reads packets periodically
        // (This is simulated by the receivePacket method in Bob class)
    }
}
