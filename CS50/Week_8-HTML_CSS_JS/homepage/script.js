// TODO: Add code to check answers to questions
document.addEventListener('DOMContentLoaded', function() {
    // For Question 1
    // Button turns green if correct answers is selected
    let correct = document.querySelector('.correct');
    correct.addEventListener('click', function(event) {
        correct.style.backgroundColor = 'green';
        document.querySelector('#feedback1').innerHTML = 'Correct!';
        });
    // Button turns red if incorrect answers is selected
    let incorrects = document.querySelectorAll('.incorrect');
    for(let i = 0; i < incorrects.length; i++)
    {
        incorrects[i].addEventListener('click', function(event) {
        incorrects[i].style.backgroundColor = 'red';
        document.querySelector('#feedback1').innerHTML = 'Incorrect';
        });
    }
    // For Question 2
    document.querySelector('#check').addEventListener('click', function(){
        let input = document.querySelector('input');
        // Input bar turns green if corrrect answers is enterred
        if(input.value == 'Switzerland' || input.value == 'switzerland'){
            input.style.backgroundColor = 'green';
            document.querySelector('#feedback2').innerHTML = 'Correct!';
        } else {
            // Otherwise input bar turns red if incorrrect answers is enterred
            input.style.backgroundColor = 'red';
            document.querySelector('#feedback2').innerHTML = 'Incorrect';
        }
    });
});