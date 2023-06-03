'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });

    setQueries();
});

function readline() {
    return inputString[currentLine++].split(' ');
}


// Dies to time limit on test 4
function setQueries() {
    const x = readline();
    const q = x[1];

    // Assign the n array
    let arr = readline();

    // Loop through the q queries
    for (let i = 0; i < q; i++) {
        let line = readline();

        switch (line[0]) {
            case '1':
                arr.push(line[1]);
                break;
            case '2':
                arr = arr.filter(num => num !== line[1]);
                break;
            case '3':
                console.log(arr.filter(num => arr.indexOf(num) === arr.lastIndexOf(num)).length);
                break;
            case '4':
                console.log(arr.includes(line[1]) ? 1 : 0);
                break;
        }
    }
}
