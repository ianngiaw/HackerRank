first_line = gets
first_line.strip!
n, k, q = first_line.split(' ').map { |s| s.to_i }

second_line = gets
second_line.strip!
a = second_line.split(' ')
a = a.map { |an| an.to_i }

unless a.length == n
    puts 'a.length != n'
    exit
end

k = k % n
a = a[-k..-1] + a[0..-k-1]

q.times do
    index = gets
    index = index.to_i
    puts a[index]
end
