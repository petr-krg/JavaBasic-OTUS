"use strict"

function addRowStudentsTable(tableID) {
    const studentsTbl = document.getElementById(tableID);

    const studentName = document.getElementById("nameStudent").value;
    const genderName  = document.getElementById("nameGender").value;
    const birthDate   = document.getElementById("dateBirth").value;

    const newRow = studentsTbl.insertRow(studentsTbl.rows.length);

    const cellStudentName = newRow.insertCell(0); 
    const cellGenderName  = newRow.insertCell(1);
    const cellBirthDate   = newRow.insertCell(2);
    const cellAgeStudents = newRow.insertCell(3);
    const age = getAgeStudent(birthDate);

    cellStudentName.appendChild(document.createTextNode(studentName));
    cellGenderName.appendChild(document.createTextNode(genderName));
    cellBirthDate.appendChild(document.createTextNode(new Date(birthDate).toLocaleDateString()))
    cellAgeStudents.appendChild(document.createTextNode(age));

    document.getElementById("ageAverage").innerHTML = getStudentAverageAge(3);
}

function getAgeStudent(dateBirth) {
    let now = new Date();
    let birthDate = new Date(dateBirth);
    let age = now.getFullYear() - birthDate.getFullYear();
    let monthBirth = now.getMonth() - birthDate.getMonth();
    if (monthBirth < 0 || (monthBirth === 0 && now.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}

function getStudentAverageAge(colAge) {
    let ageArray = new Array();
    const tblStudent = document.getElementById("tblStudents");
  
    for (let i = 0; i < tblStudent.rows.length; i++) {
        let row = tblStudent.rows[i];
        ageArray.push(parseInt(row.cells[colAge].firstChild.nodeValue));
    }
    return getAverageAge(ageArray);
}

function getAverageAge(arrAge) {
    let ageSum = 0;
    for (let i = 0; i < arrAge.length; i++) {
        ageSum += arrAge[i];
    }
    return Math.floor(ageSum / arrAge.length);
};


  