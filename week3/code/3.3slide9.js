var Instructor = function(fName, lName, cT = []) {
    this.firstName = fName;
    this.lastName = lName;
    this.classesTeaching = cT;
    this.employer = "Platform";
}

Instructor.prototype.info = function() {
    console.log(this.firstName, this.lastName, "is employed by", this.employer)
}