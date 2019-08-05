function one(v) {
    let data = v;
    if (localStorage.getItem('f') == undefined) {
        document.getElementById('display').value = data;
        localStorage.setItem("f", data);
    } else {
        localStorage.setItem('n', data);
        let s = localStorage.getItem('f');
        document.getElementById('display').value = s + data;
        localStorage.setItem('f', s + data);
    }

}

function main_f() {
    if (localStorage.getItem('result') == undefined) {
        let data1 = localStorage.getItem('f');
        let operation = eval(data1);
        localStorage.setItem('result', operation);
        //    console.log(operation); 
        document.getElementById('display').value = operation;
    } else {
        let j = localStorage.getItem('n');
        let v1 = JSON.parse(j);
        let v2 = JSON.parse(localStorage.getItem('result'));
        operation1 = eval(v1 + v2);
        localStorage.setItem('result', operation1);
        document.getElementById('display').value = operation1;
    }
}