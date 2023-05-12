# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

 My overall approach to tackling this project was to sketch out what I thought my needed classes were and their relationships, and use this to build it one class at a time. That meant I had the fundamentals that I needed for functionality when I moved on to the next class, and it was easy to track where I needed to add methods and attributes within the game.
 
 I learned how to use guava to create graphs! There were quite a few difficulties in setting up guava and making sure I had all of the right files, as well as troubleshooting how to build and use a graph, but I managed to figure out the skills that I needed. I also learned computer science applications of graph theory that I had previously learned in math classes, which was cool.

 I wish that I had been able to have the user commands as strings instead of integers, because it meant I had to do a decent amount of converting between integers and the variable type that I wanted. However, my program kept crashing with string inputs, and the debugging and showing appropriate error messages for incorrect inputs was much more extensive, so for the sake of time and the constraints of this projected I implemented all the inputs as integers because I saw another classmate doing that during the game demo day.

 If I had unlimited time, I would have implemented a feature where the user was constructing their own graph to string together the clues and I also would have had an original story about the mystery, but I couldn't figure out how to implement a mutable graph in guava and how to naturally integrate that aspect into the story of the game. I also would have done more comprehensive error handling (I didn't throw any runtime error exceptions because I didn't have confidence in being able to catch and handle them). I also wished that I would have been able to figure out unit testing, because I think that would have been a time saver and also just a useful skill to know.

 The most helpful piece of feedback I got was from Jessica in class, who suggested that I add clues that are available later in the game and impacted by gameplay. I think it really added to the story of the game and made it so that each game experience could be unique.

 I would tell myself to reduce my expectations and focus on what I could realistically produce in the given time. I would also tell myself that the simplest approach is likely the most efficient, logical, and best option.
