import * as fs from "fs";

const day1_1 = () => {
  const words = fs.readFileSync("day1_1.txt", "utf-8");

  const elves = words.split("\n\n").map((elf) =>
    elf
      .split("\n")
      .map((x) => Number(x))
      .reduce((curr, res) => {
        return res + curr;
      }, 0)
  );

  elves.sort((a, b) => b - a);
  console.log(elves[0]);
};

day1_1();
