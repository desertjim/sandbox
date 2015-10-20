defmodule Sum do
   def sum(n) when n == 0, do: 0
   def sum(n), do: n + sum(n - 1)
end

IO.puts Sum.sum(2)
