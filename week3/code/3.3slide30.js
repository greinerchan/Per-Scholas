<script>
    let LinkedList = function() {
        this.head = null;
        this.size = 0;
        this.addtoTail = function(v) {
        let node = new Node(v);
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
    }
    let node = function(v) {
        this.value = v;
        this.next = null;
    }
</script>