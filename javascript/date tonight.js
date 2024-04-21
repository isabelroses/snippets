const out = "what's your perfect first date?"
  .split("")
  .map(parseInt)
  .filter(a => a)
  .reduce((a, b) => a + b)
  .toString()
  .split("")
  .reverse()
  .join("");

console.log(out);
