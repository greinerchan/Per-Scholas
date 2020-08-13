var reducedFile = new Array();
function readSingleFile(evt) {
    //Retrieve the first (and only!) File from the FileList object
    var f = evt.target.files[0];

    if (f) {
        var r = new FileReader();
        r.onload = function (e) {
            var contents = e.target.result;
            //console.log("Where the content is: ",contents.split("\n"))
            mainEntry(contents);
        }
        console.log(r.readAsText(f));
    } else {
        alert("Failed to load file");
    }
}
document.getElementById('fileinput').addEventListener('change', readSingleFile, false);

function mainEntry(fileContentLoaded) {
    //        this is an example use
    //console.log("Where the content is: ",fileContentLoaded.split("\n"))
    var splitContent = fileContentLoaded.split("\n");
    //call method
    //do logic
    //var result = splitOnSpace(splitContent[0]);
    for (let i = 0; i < splitContent.length; i++) {
        if (isValid(splitOnSpace(splitContent[i]).before)) {
            reducedFile.push(splitContent[i]);
        }   
    }   
}

function splitOnSpace(s) {
    // reset strings
    var obj = {
        before: "",
        after: ""
    }
    // accumulate before space
    var i = 0;
    while (i < s.length && s[i] != " ") { obj.before += s[i]; i++; }
    // skip the space
    i++;
    // accumulate after space
    while (i < s.length) { obj.after += s[i]; i++; }
    return obj;
}

function isValid(word) {
    var allStr = /^[a-zA-Z']+$/;
    if (!allStr.test(word)) {
        return false;
    }
    return true;
}


// Phase I, User enters a word, and the program only reports pronunciation as a list of phonemes. Example: 
function pronunciation(word) { 
    //let word = prompt("please enter a single word").toUpperCase();
    for (let i = 0; i < reducedFile.length; i++) {
        let cur = splitOnSpace(reducedFile[i]);
        if (word === cur.before) {
            //console.log(cur.after);
            return cur.after;
        } 
    }
    console.log(false); 
    return [];
}

// Phase II, User enters a word — the program reports pronunciation as a list of phonemes AND a list of words that sound the same (is made up of exactly the same sequence of phonemes.
function samePhoneme(word) {
    var list = new Array();
    //let word = prompt("please enter a single word").toUpperCase();
    for (let i = 0; i < reducedFile.length; i++) {
        let cur = splitOnSpace(reducedFile[i]);
        if (word === cur.before) {
            let phoneme = cur.after;
            for (let i = 0; i < reducedFile.length; i++) {
                let cur2 = splitOnSpace(reducedFile[i]);
                if (phoneme === cur2.after && word != cur2.before) {
                    list.push(cur2.before);
                }                  
            }
        } 
    } 
    //console.log(list);
    return list;  
}

//Phase III, In addition to the functionality of phases I and II, print a list of words that can be obtained by replacing just one phoneme — words made up of exactly the same sequence of phonemes with just one of them different
function oneDifference(word) {
    //let word = prompt("please enter a single word").toUpperCase();
    let list = new Array();
    pronunciationArr = pronunciation(word).trim().split(/\s+/);
    for (let i = 0; i < reducedFile.length; i++) {
        let cur = splitOnSpace(reducedFile[i]);
        let curArr = cur.after.trim().split(/\s+/);
        if (strCmpr(pronunciationArr, curArr)) {
            list.push(cur.before);
        }
    }
    //console.log(list);
    return list;
}

function strCmpr(first, second) {
    let diffNum = 0;
    // len diff
    if (first.length != second.length) {
        return false;
    }
    for (let i = 0; i < first.length; i++) {
        if (first[i] !== second[i]) {
            diffNum += 1;
        }
    }
    if (diffNum != 1) {
        return false;
    } else {
        return true;
    }
}

//Phase IV, Phase IV In addition to the functionality of phases I, II and III, print a list of words that can be obtained by adding just one phoneme — words made up of exactly the same sequence of phonemes with just one additional one — anywhere in the original sequence of phonemes.
function oneMore(word) {
    //let word = prompt("please enter a single word").toUpperCase();
    let list = new Array();
    pronunciationArr = pronunciation(word).trim().split(/\s+/);
    for (let i = 0; i < reducedFile.length; i++) {
        let cur = splitOnSpace(reducedFile[i]);
        let curArr = cur.after.trim().split(/\s+/);
        if (strCmpr2(pronunciationArr, curArr)) {
            list.push(cur.before);
        }
    }
    //console.log(list);
    return list;
}


function strCmpr2(first, second) {
    let diffNum = 0; let lp = 0; let rp = 0; let flag = true;
    // len diff
    if ((first.length + 1) != second.length) {
        return false;
    }
    while (flag && lp < first.length && rp < second.length) {
        if (first[lp] !== second[rp]){
            diffNum++;
            rp++;
        } else {
            lp++; rp++;
        }
        if (diffNum > 1) {
            flag = false;
        }
    }
    if (!flag) {
        return false;
    } else {
        return true;
    }
}

//Phase VI, Remove phoneme   
function oneLess(word) {
    //let word = prompt("please enter a single word").toUpperCase();
    let list = new Array();
    pronunciationArr = pronunciation(word).trim().split(/\s+/);
    for (let i = 0; i < reducedFile.length; i++) {
        let cur = splitOnSpace(reducedFile[i]);
        let curArr = cur.after.trim().split(/\s+/);
        if (strCmpr2(curArr, pronunciationArr)) {
            list.push(cur.before);
        }
    }
    //console.log(list);
    return list;
}

function main() {
    let word = prompt("please enter a single word").toUpperCase();
    while (pronunciation(word) === 0) {
        word = prompt("please enter again").toUpperCase();
    }
    phaseI = pronunciation(word);
    phaseII = samePhoneme(word);
    phaseIII = oneDifference(word);
    phaseIV = oneMore(word);
    phaseV = oneLess(word);
    console.log("Pronunciation: " + phaseI);
    console.log("Identical: " + phaseII.toString());
    console.log("Replace phoneme : " + phaseIII.toString());
    console.log("Add phoneme: " + phaseIV.toString());
    console.log("Remove phoneme: " + phaseV.toString());
}