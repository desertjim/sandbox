defmodule Matrix do

   def generate(mar) do
       Enum.each(100..999, fn (x) -> generate(x, mar) end)
   end

   def generate(x, mar) do
       Enum.each(100..999, fn (y) -> Map.put(mar, x<>"*"<>y, Map.new([{:x, x}, {:y, y}, {:xy, x * y}]) ) end)
   end

   def convert(x,y) do
       #IO.puts(to_string(x)<>" "<> to_string(y)) 
       value = x * y
       String.reverse(to_string(value)) == to_string(value)
   end

  def find(z) do
      Enum.filter(Enum.zip(Enum.into(100..999, [], fn(_) -> z end), Enum.into(100..999, [], fn(x) -> x end)), fn(x) -> Matrix.convert(elem(x,0),elem(x,1)) end)
  end
end

IO.inspect Enum.at(Enum.sort(Enum.into(Enum.flat_map(Enum.into(100..999, [], fn(x) -> Matrix.find(x) end) , fn(x) -> x end), [], fn(x) -> elem(x,0) * elem(x,1) end), fn(x,y) -> x > y end), 0)
