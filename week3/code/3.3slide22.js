function counter(n) {
    return {
        get count() {return n++} ,
            set count(m){
                if (m>= n){n=m;}
                else{throw Error("count too small");}
            }
        };
    }
var c=counter(1000);
console.log(c.count);  console.log(c.count);
c.count =2000;         console.log(c.count);
//c.count = 2000;  //wil fail(not Larger)
c.count=2001;          console.log(c.count);


