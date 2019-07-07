# Lambda Calculus
####

## Lambda Calculus - Reductions #1

* ((λx.(x y))(λz.z))

((λx.(x y))(λz.z))  
= (λx.(x y))(λz.z)  
= ((λz.z)y)  
= (λz.z)y  
= y  

## Lambda Calculus - Reductions #2
   
* ((λx.((λy.(x y))x))(λz.w))

((λx.((λy.(x y))x))(λz.w))    
= (λx.((λy.(x y))x))(λz.w)  
= (λy.((λz.w) y))(λz.w)  
= ((λz.w) (λz.w))  
= (λz.w)  
= [(λz.w)/z]w    
= w  