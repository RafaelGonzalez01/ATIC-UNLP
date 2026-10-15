package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class TestParcialArboles {

    public static void main(String[] args) {

        // ====================== CONSTRUCCIÓN DEL ÁRBOL ======================
        BinaryTree<Integer> raiz = new BinaryTree<>(20);

        BinaryTree<Integer> n10 = new BinaryTree<>(10);
        BinaryTree<Integer> n30 = new BinaryTree<>(30);
        raiz.addLeftChild(n10);
        raiz.addRightChild(n30);

        BinaryTree<Integer> n5  = new BinaryTree<>(5);
        BinaryTree<Integer> n15 = new BinaryTree<>(15);
        BinaryTree<Integer> n25 = new BinaryTree<>(25);
        BinaryTree<Integer> n35 = new BinaryTree<>(35);

        n10.addLeftChild(n5);
        n10.addRightChild(n15);
        n30.addLeftChild(n25);
        n30.addRightChild(n35);

        // Nodos con un solo hijo (importante para probar el -1)
        n5.addLeftChild(new BinaryTree<>(3));                    // 5 tiene solo hijo izquierdo

        n15.addRightChild(new BinaryTree<>(18));                 // 15 tiene solo hijo derecho

        BinaryTree<Integer> n22 = new BinaryTree<>(22);
        n25.addLeftChild(n22);

        n35.addRightChild(new BinaryTree<>(40));                 // 35 tiene solo hijo derecho

        // Nivel 4
        n22.addLeftChild(new BinaryTree<>(21));                  // 22 tiene solo hijo izquierdo

        BinaryTree<Integer> n3 = n5.getLeftChild();
        n3.addRightChild(new BinaryTree<>(4));                   // 3 tiene solo hijo derecho

        BinaryTree<Integer> n18 = n15.getRightChild();
        n18.addLeftChild(new BinaryTree<>(17));                  // 18 tiene solo hijo izquierdo

        // ====================== IMPRESIÓN DEL ÁRBOL ======================
        System.out.println("=== ÁRBOL CONSTRUIDO ===\n");
        imprimirArbol(raiz, "", true);
        System.out.println("\n");

        // ====================== PRUEBAS DEL MÉTODO ======================
        ParcialArboles parcial = new ParcialArboles(raiz);

        System.out.println("=== RESULTADOS DE isLeftTree ===");
        System.out.println("20 (raíz)      → " + parcial.isLeftTree(20));
        System.out.println("10             → " + parcial.isLeftTree(10));
        System.out.println("5  (solo izq)  → " + parcial.isLeftTree(5));
        System.out.println("15 (solo der)  → " + parcial.isLeftTree(15));
        System.out.println("25             → " + parcial.isLeftTree(25));
        System.out.println("35 (solo der)  → " + parcial.isLeftTree(35));
        System.out.println("22 (solo izq)  → " + parcial.isLeftTree(22));
        System.out.println("99 (no existe) → " + parcial.isLeftTree(99));
    }

    // ==================== IMPRESIÓN DEL ÁRBOL (versión clara) ====================
    private static void imprimirArbol(BinaryTree<Integer> nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) return;

        System.out.print(prefijo);

        if (esUltimo) {
            System.out.print("└── ");
            prefijo += "    ";
        } else {
            System.out.print("├── ");
            prefijo += "│   ";
        }

        System.out.println(nodo.getData());

        boolean tieneIzq = nodo.hasLeftChild();
        boolean tieneDer = nodo.hasRightChild();

        if (tieneIzq) {
            imprimirArbol(nodo.getLeftChild(), prefijo, !tieneDer);
        }
        if (tieneDer) {
            imprimirArbol(nodo.getRightChild(), prefijo, true);
        }
    }
}