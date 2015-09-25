IO.puts Enum.reduce(Enum.filter(1..999, fn(x) -> rem(x,3) == 0 || rem(x,5) == 0 end), fn(x, acc) -> x+acc end)
