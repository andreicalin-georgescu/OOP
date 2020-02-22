package Array;

final class Test {

    private Test() {
    }

    public static void main(final String[] args) {

        QueueAggregation queueAggregation = new QueueAggregation(3);

        queueAggregation.push(1);
        queueAggregation.push(2);
        queueAggregation.push(3);
        queueAggregation.push(4);

        System.out.println(queueAggregation.pop());
        System.out.println(queueAggregation.pop());
        System.out.println(queueAggregation.pop());
        System.out.println(queueAggregation.pop());

        /* ------------------------------ */

        QueueInheritance queueInheritance = new QueueInheritance(3);

        queueInheritance.push(1);
        queueInheritance.push(2);
        queueInheritance.push(3);
        queueInheritance.push(4);

        System.out.println(queueInheritance.pop());
        System.out.println(queueInheritance.pop());
        System.out.println(queueInheritance.pop());
        System.out.println(queueInheritance.pop());

        // Problema apare deoarece ii expunem utilizatorului mai
        // mult decat are nevoie, atunci cand folosim mostenire.
        queueInheritance.set(2, 10);

        System.out.println(queueInheritance.get(2));
    }
}

