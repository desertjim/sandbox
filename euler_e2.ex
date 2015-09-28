defmodule Fib do
   def fib2 do
      Stream.unfold({0, 1}, fn {a, b} -> {a, {b, a + b}} end)
   end
end


IO.inspect Enum.reduce(Enum.filter(Fib.fib2 |> Enum.take(4000000), fn (x) -> rem(x,2) == 0 end), fn (x, acc) -> x + acc end) 
