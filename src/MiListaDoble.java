public class MiListaDoble implements ListInterface{

    private DoubleNode cabeza;
    private DoubleNode cola;
    private int size;

    public MiListaDoble() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return cabeza == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
    cabeza = null;
    cola = null;
    size = 0;
    }

    @Override
    public Object getHead() {
        if (isEmpty()) {
            return null;
        }
        return cabeza.dato;
    }

    @Override
    public Object getTail() {
        if(isEmpty()){
            return null;
        }
        return cola.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        if(node==null){
            return null;
        }
        return node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode current = cabeza;

        while(current != null){
            if (current.dato.equals(object)){
                return current;
            }
            current = current.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {

        DoubleNode newNode = new DoubleNode(object);

          if (isEmpty()) {
            cabeza = newNode;
            cola = newNode;
          } else {
            cola.siguiente = newNode;
            newNode.anterior = cola;
            cola = newNode;
          }

        size++;
        return true;
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        if (node == cola) {
            return insertTail(object);
        }

        DoubleNode newNode = new DoubleNode(object);
        DoubleNode nextNode = node.siguiente;

        node.siguiente = newNode;
        newNode.anterior = node;

        newNode.siguiente = nextNode;
        nextNode.anterior = newNode;

        size++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode referenceNode = search(objectRef);

        if (referenceNode == null) {
            return false;
        }
        return insert(referenceNode, object);
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode newNode = new DoubleNode(object);

        if (isEmpty()) {
            cabeza = newNode;
            cola = newNode;
        } else {
            newNode.siguiente = cabeza;
            cabeza.anterior = newNode;
            cabeza = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {

        return add(object);
        }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }
    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) {
            return false;
        }

        if (node.anterior != null) {
            node.anterior.siguiente = node.siguiente;
        } else {
            cabeza = node.siguiente;
        }
        if (node.siguiente != null) {
            node.siguiente.anterior = node.anterior;
        } else {
            cola = node.anterior;
        }
        node.anterior = null;
        node.siguiente = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {

            Object[] objects = new Object[size];
            DoubleNode current = cabeza;
            int index = 0;

            while (current != null) {
                objects[index] = current.dato;
                current = current.siguiente;
                index++;
            }

            return objects;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object == null || object.length < size) {
            object = new Object[size];
        }
        DoubleNode current = cabeza;
        int index = 0;
        while (current != null) {
            object[index] = current.dato;
            current = current.siguiente;
            index++;
        }
        if (object.length > size) {
            object[size] = null;
        }
        return object;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble newList = new MiListaDoble();

        if (from == null || to == null) {
            return newList;
        }
        DoubleNode current = from;
        while (current != null) {
            newList.add(current.dato);
            if (current == to) {
                return newList;
            }
            current = current.siguiente;
        }
        newList.clear();
        return newList;
    }

    @Override
    public MiListaDoble sortList() {

    MiListaDoble sortedList = new MiListaDoble();

        DoubleNode current = cabeza;

        while (current != null) {
            sortedList.add(current.dato);
            current = current.siguiente;
        }

        if (sortedList.size < 2) {
            return sortedList;
        }

        boolean swapped;

        do {
            swapped = false;
            current = sortedList.cabeza;

            while (current.siguiente != null) {
                Comparable<Object> left =
                        (Comparable<Object>) current.dato;

                if (left.compareTo(current.siguiente.dato) > 0) {
                    Object temporary = current.dato;
                    current.dato = current.siguiente.dato;
                    current.siguiente.dato = temporary;

                    swapped = true;
                }

                current = current.siguiente;
            }
        } while (swapped);

        return sortedList;
    }
    }
