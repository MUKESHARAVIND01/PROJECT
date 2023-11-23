function inputValue(num) {
    let displayInput = document.getElementById("display");
    displayInput.value += num;
}

function operator(symbol) {
    let displayInput = document.getElementById("display");
    displayInput.value += symbol;
}

function equal() {
    let displayInput = document.getElementById("display");
    displayInput.value = eval(displayInput.value);
}

function AC() {
    let displayInput = document.getElementById("display");
    displayInput.value = "";
}

function del() {
    let displayInput = document.getElementById("display");
    displayInput.value = displayInput.value.slice(0, -1);
}
