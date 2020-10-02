<script>
  var Instructor = function(fName, lName, cT = []){
    this.firstName = fName;
    this.lastName = lName;
    this.classesTeaching = cT;
    this.employer = "Platform";
    this.info = function(){
      console.log(this.firstName,
        this.lastName,
        "is employed by",
        this.employer)
    }
}
var shah = new Instructor("A H M", "Shahparan", ["Full-Stack", "DE"]);
var kieda = new Instructor("Kieda", "Maliqi", ["Full-Stack"]);
var bairon = new Instructor("Bairon J.", "Vasquez");
console.log(shah);
console.log(kieda);
console.log(bairon);
</script>