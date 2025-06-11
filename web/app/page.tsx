import api from '@/lib/api';

type Puppy = { id:number; name:string; breed:string; priceUsd:number; birthDate:string; sex:string };

export default async function Home() {
  const { data } = await api.get<Puppy[]>('/puppies');
  return (
    <main className="grid gap-6 p-8 sm:grid-cols-2 lg:grid-cols-3">
      {data.map(p => (
        <div key={p.id} className="rounded-xl shadow p-4 bg-white">
          <h2 className="text-xl font-semibold">{p.name}</h2>
          <p className="text-gray-600">{p.breed}</p>
          <p className="mt-2 font-bold">${p.priceUsd}</p>
        </div>
      ))}
    </main>
  );
}

