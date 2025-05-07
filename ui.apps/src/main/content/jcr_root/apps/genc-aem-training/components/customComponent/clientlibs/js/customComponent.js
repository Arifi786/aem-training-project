document.addEventListener('DOMContentLoaded', function() {
    console.log('Custom component loaded');
    // Add your JS code here
    // Example: Change the title color on click
    document.querySelector('.custom-component__title').addEventListener('click', function() {
        this.style.color = '#007BFF';
    });
});
