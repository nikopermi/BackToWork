package com.example.backtowork

open class Tree<T>(data: T) {
    private var root = Node(data)

    constructor(data: T, children: MutableList<Node<T>>) : this(data) {
        root = Node(data)
        root.children = children
    }

    class Node<T>(var data: T? = null)  {
        var parent : Node<T>? = null
        var children : MutableList<Node<T>> = mutableListOf()
        constructor(data: T, children: MutableList<Node<T>>) : this() {
            this.data = data
            this.children = children
        }

        fun add(data: T) {
            children.add(Node<T>(data))
        }

        fun add(node: Node<T>) {
            children.add(node)
        }

        fun delete() {
            // adoption
            if(children.isNotEmpty() && parent != null) {
                children[0].parent = parent
            }


        }

    }



}