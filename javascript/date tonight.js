const out = "What is your perfect date night?"
  .split("")
  .map(parseInt)
  .filter(a => a)
  .reduce((a, b) => a + b)
  .toString()
  .split("")
  .reverse()
  .join("");

console.log(out);
