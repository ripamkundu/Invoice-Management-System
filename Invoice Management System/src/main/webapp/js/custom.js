/**
 * 
 */
var typed = new Typed(".auto-type", {
	strings: ["RIGHT", "LIABILITY", "RECORD"],
	typeSpeed: 150,
	backSpeed: 150,
	loop: true
});

AOS.init({
	duration: 1000
});

const counterNum = document.querySelectorAll(".counter");

const speed = 200;

counterNum.forEach((curElem) => {
	const updateNumber = () => {
		const targetNumber = parseInt(curElem.dataset.number);
		// console.log(targetNumber);
		const initialNum = parseInt(curElem.innerText);
		// console.log(initialNum);

		const incrementNumber = Math.trunc(targetNumber / speed);
		// console.log(incrementNumber);

		if (initialNum < targetNumber) {
			curElem.innerText = `${initialNum + incrementNumber}+`;
			setTimeout(updateNumber, 10);
		}
	};

	updateNumber();
});