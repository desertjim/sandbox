defmodule Prime do
   def prime_factor(1, p, _) do
      p
   end

   def prime_factor(n, p, acc) do
      if rem(n, p) == 0 do
         prime_factor(div(n,p), p + 2, p)
      end
      if rem(n, p) != 0 do
         prime_factor(n, p + 2, acc)
      end 
   end
end

IO.puts Prime.prime_factor(600851475143, 3, [])
