function add_pro(v) {
    let su = document.getElementById(v).value;
    // console.log(su);
    let y = document.getElementById('dis').value;
    localStorage.setItem('m', su);
    localStorage.setItem('total', y);
    // console.log(localStorage.getItem('total'));
    let var1 = localStorage.getItem('total');
    var1 = var1 - su;
    localStorage.setItem('total', var1);
    document.getElementById('dis').value = var1;

}

function find_i() {
    let v1 = document.getElementById('mon').value;
    let v2 = document.getElementById('tue').value;
    let v3 = document.getElementById('wed').value;
    let v4 = document.getElementById('thu').value;
    let v5 = document.getElementById('fri').value;

}