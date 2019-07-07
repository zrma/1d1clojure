# Lambda Calculus
####

## [Lambda Calculus - Reductions #1](https://www.hackerrank.com/challenges/lambda-calculus-reductions-1)

* ((λx.(x y))(λz.z))

((λx.(x y))(λz.z))  
= (λx.(x y))(λz.z)  
= ((λz.z)y)  
= (λz.z)y  
= y  

## [Lambda Calculus - Reductions #2](https://www.hackerrank.com/challenges/lambda-calculus-reductions-2/problem)
   
* ((λx.((λy.(x y))x))(λz.w))

((λx.((λy.(x y))x))(λz.w))    
= (λx.((λy.(x y))x))(λz.w)  
= (λy.((λz.w) y))(λz.w)  
= ((λz.w) (λz.w))  
= (λz.w)  
= [(λz.w)/z]w    
= w  

## [Lambda Calculus - Reductions #3](https://www.hackerrank.com/challenges/lambda-calculus-reductions-3/problem)
   
* ((λx.(x x))(λx.(x x)))

((λx.(x x))(λx.(x x)))  
= (λx.(x x))(λx.(x x))  
= (λx.(x x))  
-> Can't Reduce (Infinite loop)  


## [Lambda Calculus - Reductions #4](https://www.hackerrank.com/challenges/lambda-calculus-reductions-4/problem)

* (λg.((λf.((λx.(f (x x)))(λx.(f (x x))))) g)) 

(λg.((λf.((λx.(f (x x)))(λx.(f (x x))))) g))    
= (λg.(((λx.(g (x x)))(λx.(g (x x))))))      
= (λg.(λx.(g (x x)))(λx.(g (x x))))    
-> Can't Reduce (Infinite loop)

## [Lambda Calculus - Evaluating Expressions #1](https://www.hackerrank.com/challenges/lambda-calculus-getting-started/problem)  

* (λx.x+1)3  

(λx.x+1)3  
= (3+1)  
= 4  

## [Lambda Calculus - Evaluating Expressions #2](https://www.hackerrank.com/challenges/lambda-calculus-understanding-the-syntax/problem)  

* (λx.x+1)((λy.y+2)3)  

(λx.x+1)((λy.y+2)3)  
= (λx.x+1)(3+2)  
= (λx.x+1)(5)  
= (5+1)  
= 6  

## [Lambda Calculus - Evaluating Expressions #3](https://www.hackerrank.com/challenges/lambda-calculus-evaluate-the-expression/problem)  

> [Church encoding](https://en.wikipedia.org/wiki/Church_encoding)
> n = λx.λy.x^{n}y

* λx.λy.x^{47}y  

λx.λy.x^{47}y  
= 47  

## [Lambda Calculus - Evaluating Expressions #4](https://www.hackerrank.com/challenges/lambda-calculus-evaluate-the-expression-1/problem)  

* λx.λy.x(xy)  

λx.λy.x(xy)  
= λx.λy.x^{2}y  
= 2   

## [Lambda Calculus - Evaluating Expressions #5](https://www.hackerrank.com/challenges/lambda-calculus-evaluate-the-expression-2/problem)  

* λx.λy.y  

λx.λy.y  
= 0