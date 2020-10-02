
var LinkedList = function () {
    this.head = null;
    this.size = 0;
    this.addToTail = function (v) {
        var node = new Node(v);
        if (this.head === null) {
            this.head = node;
            this.size++
            return
        }
        let current = this.head;
        while (current.next != null) {
            current = current.next
        }
        current.next = node;
        this.size++;
    }
    var Node = function(v) {
        this.value = v;
        this.next = null;
    }
    this.insertAtIndex = function (index, v) {
        var node = new Node(v);
        if (index < 0 || index > this.size) {
            delete node;
            return;
        }
        if (this.head === null) {
            this.head = node;
            this.size++;
            return;
        }
        if (index === 0) {
            delete node;
            this.addToHead(v);
            return;
        }
        if (index === this.size) {
            delete node;
            this.addToTail(v);
            return;
        }
        var i = 0;
        var current = this.head;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        node.next = current.next;
        current.next = node;
        this.size++;
    }

    function printList() {
        let output = new Array();
        let cur = this.head;
        while (cur !== null) {
            output.push(cur.value);
            cur = cur.next;
        }
        console.log(result.output(' -> '));
    }
    function deleteData(v) {
        var cur = this.head;
        if (cur.data = data) {
            this.head = null;
        }
        while (cur.value != data) {
            if (cur.data === data) {
                prev === cur.next;
            }
            prev = cur;
            cur = cur.next;
        }          
    }
}