function hoist() { a = 20; var b = 100; } 
hoist(); 
console.log(a); 
//console.log(b);