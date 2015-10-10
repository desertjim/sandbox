defmodule Prime do
   def prime_factor(_, 0, p, _) do
      p
   end

   def prime_factor(_, 1, p, _) do
      p
   end

   def prime_factor(:true, n, p, _) do
     newN = div(n,p)
     prime_factor(div(newN,p) == newN / p, newN, p, p)
   end

   def prime_factor(:false, n, p, acc) do
      truth = (div(n,p) == ( n / p))
      p = case truth do
         :true  -> p
         :false -> p + 2
      end

      prime_factor(truth, n, p, acc)
   end

   def prime_factor(n) do
       prime_factor(div(n,3) == n / 3 , n, 3, 1)
   end

end

IO.puts Prime.prime_factor(600851475143)
