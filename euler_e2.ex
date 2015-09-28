defmodule Fib do
   def fib2 do
      Stream.unfold({0, 2}, fn {a, b} -> {a, {b, a+(4*b)}} end)
   end
end

IO.inspect Enum.reduce(Fib.fib2 |> Enum.take(12), fn (x, acc) -> x + acc end)
