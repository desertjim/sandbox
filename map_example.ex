{:ok, file} = File.open "./sort.txt", [:read]  # get file for reading
content = IO.read(file, :all)                  # read the contents
content = String.codepoints(content)           # convert it to a string
content = Enum.filter(content, fn char -> char =~ ~r/[a-z,_]/ end) # filter out whitespace
content = Enum.reduce(content, Map.new, fn char,contents -> Dict.update(contents, char, 1, &(&1+1)) end) # put characters into a map with key being the char and value being the count
IO.puts content # display the map
